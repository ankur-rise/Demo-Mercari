package com.mercari.mercaritest.ui.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import butterknife.BindView
import butterknife.ButterKnife
import com.mercari.mercaritest.R
import com.mercari.mercaritest.data.models.DataModel
import com.mercari.mercaritest.di.Injector
import com.mercari.mercaritest.ui.KEY_URL
import com.mercari.mercaritest.ui.contracts.FragmentContract

import com.mercari.mercaritest.ui.presenter.DataPresenter
import javax.inject.Inject

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [DealFragment.OnListFragmentInteractionListener] interface.
 */
class DealFragment : Fragment(), FragmentContract.View {
    override fun showProgress() {
        pb.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        pb.visibility = View.GONE
    }

    override fun getUrl(): String {
        return url!!
    }

    override fun showData(list: List<DataModel>) {
        rl.adapter = MyItemRecyclerViewAdapter(list)
        rl.layoutManager = GridLayoutManager(context, columnCount)
    }

    private var url: String? = null
    private var columnCount: Int = 2

    private var listener: OnListFragmentInteractionListener? = null

    @BindView(R.id.list)
    lateinit var rl: RecyclerView

    @BindView(R.id.pb)
    lateinit var pb: ProgressBar

    @Inject
    lateinit var mPresenter:DataPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            url = it.getString(KEY_URL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        // Set the adapter
        ButterKnife.bind(this, view)

        val component = Injector.getActivityCompo()
        component.inject(this)

        mPresenter.bindView(this)
        mPresenter.start()

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {

        fun onListFragmentInteraction(item: String?)
    }

}

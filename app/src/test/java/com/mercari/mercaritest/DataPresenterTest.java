package com.mercari.mercaritest;

import com.mercari.mercaritest.data.models.DataModel;
import com.mercari.mercaritest.data.models.RawDataModel;
import com.mercari.mercaritest.domain.IDataRepo;
import com.mercari.mercaritest.domain.usecases.DataUseCase;
import com.mercari.mercaritest.ui.contracts.FragmentContract;
import com.mercari.mercaritest.ui.contracts.IMainContract;
import com.mercari.mercaritest.ui.presenter.DataPresenter;
import com.mercari.mercaritest.ui.presenter.MainPresenter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public    class DataPresenterTest   {
    private DataPresenter presenter;
    @Mock
    private DataUseCase dataUseCase;
    @Mock
    private FragmentContract.View mView;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        presenter = new DataPresenter(dataUseCase);
        presenter.bindView(mView);
    }

    @Test
    public void testStart() {
        presenter.start();
        verify(mView).showProgress();

        ArgumentCaptor<IDataRepo.RepoCallback> captor = ArgumentCaptor.forClass(IDataRepo.RepoCallback.class);
        verify(dataUseCase).getData(anyString(), captor.capture());
        IDataRepo.RepoCallback<List<DataModel>> callback = captor.getValue();
        List<DataModel> list = new ArrayList<>();
        callback.onSuccess(list);
        verify(mView).hideProgress();
        verify(mView, times(1)).showData(list);

    }
}

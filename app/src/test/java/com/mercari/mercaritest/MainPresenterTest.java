package com.mercari.mercaritest;

import com.mercari.mercaritest.data.models.RawDataModel;
import com.mercari.mercaritest.domain.IDataRepo;
import com.mercari.mercaritest.domain.usecases.DataUseCase;
import com.mercari.mercaritest.ui.contracts.IMainContract;
import com.mercari.mercaritest.ui.presenter.MainPresenter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

public    class MainPresenterTest {
    private MainPresenter presenter;
    @Mock
    private DataUseCase dataUseCase;
    @Mock
    private IMainContract.View mView;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        presenter = new MainPresenter(dataUseCase);
        presenter.bindView(mView);
    }

    @Test
    public void testStart() {
        presenter.start();
        verify(mView).showProgress();

        ArgumentCaptor<IDataRepo.RepoCallback> captor = ArgumentCaptor.forClass(IDataRepo.RepoCallback.class);
        verify(dataUseCase).getRawData(captor.capture());
        IDataRepo.RepoCallback<List<RawDataModel>> callback = captor.getValue();
        callback.onSuccess(new ArrayList<RawDataModel>());
        verify(mView).hideProgress();

    }

}

package se.apals.brooklynmuseum;

import android.app.Application;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import rx.Observable;
import se.apals.brooklynmuseum.components.images.master.ImagesContract;
import se.apals.brooklynmuseum.components.images.master.ImagesPresenter;
import se.apals.brooklynmuseum.data.DataManager;
import se.apals.brooklynmuseum.models.ArchiveImage;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by apals on 03/08/16.
 */
public class ImagesPresenterTest {

    @Mock
    private ImagesContract.View imageView;

    @Mock
    private DataManager dataManager;

    @Mock
    private Application application;

    private ImagesPresenter imagesPresenter;

    private ArrayList<ArchiveImage> mImagesMockList;

    @Before
    public void setupArchiveImageListPresenter() {
        // Create the mocks for these tests
        MockitoAnnotations.initMocks(this);

        mImagesMockList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            ArchiveImage e = new ArchiveImage();
            e.setId(i);
            e.setTitle("Mock-ArchiveImage-" + i);
            mImagesMockList.add(e);
        }

        Mockito.doReturn(mockArchiveImageStream()).when(dataManager).getImages();
        imagesPresenter = new ImagesPresenter(imageView, dataManager, application);
        imageView.setPresenter(imagesPresenter);
    }

    private Observable<ArrayList<ArchiveImage>> mockArchiveImageStream() {
        ArrayList[] obList = new ArrayList[1];
        obList[0] = mImagesMockList;
        return Observable.from(obList);
    }

    @Test
    public void testSelectImage() {
        ArchiveImage event = new ArchiveImage();

        imagesPresenter.onImageClicked(null, event);

        // Should tell the view to show the event details page
        verify(imageView, times(1)).showImageDetailView(null, event);
    }

    @Test
    public void testDataLoaded() {
        ArrayList<ArchiveImage> events = new ArrayList<>();
        events.add(new ArchiveImage());
        events.add(new ArchiveImage());
        events.add(new ArchiveImage());

        imagesPresenter.onImagesLoaded(events);

        verify(imageView, times(1)).setImages(events);
    }

}

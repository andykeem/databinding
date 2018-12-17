package loc.example.foo.myapp20181215;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private SharedViewModel mSharedViewModel;
    private int mCnt;
//    private ObservableField<String> mName = new ObservableField<>();
    private String mName;

    public String getCount() {
        return String.format("Step %d", mCnt);
    }

    public void setCount(int cnt) {
        mCnt = cnt;
    }

    public void onPrevButtonClick() {
        mCnt -= 1;
        mSharedViewModel.click(mCnt);
    }

    public void onNextButtonClick() {
        mCnt += 1;
        mSharedViewModel.click(mCnt);
        if (!mSharedViewModel.hasName() || !mSharedViewModel.getName().equals(mName)) {
            mSharedViewModel.setName(mName);
        }
    }

    public void setSharedViewModel(SharedViewModel viewModel) {
        mSharedViewModel = viewModel;
    }

    public String getName() {
        if (mSharedViewModel.hasName()) {
            mName = mSharedViewModel.getName();
        }
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
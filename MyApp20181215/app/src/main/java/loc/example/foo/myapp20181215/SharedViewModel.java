package loc.example.foo.myapp20181215;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.text.TextUtils;

public class SharedViewModel extends ViewModel {

    private MutableLiveData<Integer> mClicked = new MutableLiveData<>();
    private String mName;

    public void click(int cnt) {
        mClicked.setValue(cnt);
    }

    public LiveData<Integer> getClicked() {
        return mClicked;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public boolean hasName() {
        return !TextUtils.isEmpty(mName);
    }
}

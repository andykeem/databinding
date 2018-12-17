package loc.example.foo.myapp20181215;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private SharedViewModel mViewModel;
    private int mCnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = this.getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.fragment_container);
        if (f == null) {
            f = MainFragment.newInstance(mCnt);
            fm.beginTransaction()
                    .add(R.id.fragment_container, f)
                    .commit();
        }

        mViewModel = ViewModelProviders.of(this).get(SharedViewModel.class);
        mViewModel.getClicked().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer cnt) {
                mCnt = cnt;
                replaceFragment();
            }
        });
    }

    protected void replaceFragment() {
        Fragment f = MainFragment.newInstance(mCnt);
        String tag = "FRAGMENT_TAG_" + mCnt;
        this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, f, tag)
                .commit();
    }
}

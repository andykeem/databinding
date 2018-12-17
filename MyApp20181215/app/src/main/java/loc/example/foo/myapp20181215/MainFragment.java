package loc.example.foo.myapp20181215;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import loc.example.foo.myapp20181215.databinding.FragmentMainBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private static final String TAG = MainFragment.class.getSimpleName();
    private static final String ARG_CNT = "ARG_CNT";

    private FragmentMainBinding mBinding;
    private SharedViewModel mSharedViewModel;
    private MainViewModel mViewModel;
    private int mCnt;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.getArguments() != null) {
            mCnt = this.getArguments().getInt(ARG_CNT);
        }
        mSharedViewModel = ViewModelProviders.of(this.getActivity()).get(SharedViewModel.class);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.setCount(mCnt);
        mViewModel.setSharedViewModel(mSharedViewModel);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View v = inflater.inflate(R.layout.fragment_main, container, false);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        mBinding.setViewModel(mViewModel);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public static MainFragment newInstance(int cnt) {
        MainFragment f = new MainFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_CNT, cnt);
        f.setArguments(args);
        return f;
    }
}

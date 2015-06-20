package ca.josephroque.partners.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ca.josephroque.partners.R;
import ca.josephroque.partners.interfaces.ActionButtonHandler;

/**
 * A simple {@link Fragment} subclass. Use the {@link HeartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HeartFragment
        extends Fragment
        implements ActionButtonHandler
{
    /**
     * Use this factory method to create a new instance of this fragment using the provided
     * parameters.
     *
     * @return A new instance of fragment HeartFragment.
     */
    public static HeartFragment newInstance()
    {
        return new HeartFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_heart, container, false);
    }

    @Override
    public void handleActionClick()
    {
        // TODO: send thought
    }
}
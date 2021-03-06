package ca.josephroque.partners.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;

import ca.josephroque.partners.fragment.RegisterFragment;
import ca.josephroque.partners.fragment.TutorialFragment;

/**
 * Created by Joseph Roque on 2015-07-03. Manages fragments in a view pager.
 */
public class SplashPagerAdapter
        extends FragmentStatePagerAdapter
{

    /** To identify output from this class in the Logcat. */
    @SuppressWarnings("unused")
    private static final String TAG = "SplashPagerAdapter";

    /** Keeps weak references to fragments in the view pager. */
    private SparseArray<WeakReference<Fragment>> mRegisteredFragments;

    /**
     * Default constructor.
     *
     * @param fm fragment manager
     */
    public SplashPagerAdapter(FragmentManager fm)
    {
        super(fm);
        mRegisteredFragments = new SparseArray<>();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        mRegisteredFragments.put(position, new WeakReference<>(fragment));
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        mRegisteredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position)
    {
        if (position < TutorialFragment.TUTORIAL_PAGES)
            return TutorialFragment.newInstance(position);
        else
            return RegisterFragment.newInstance(true);
    }

    @Override
    public int getCount()
    {
        return TutorialFragment.TUTORIAL_PAGES + 1;
    }

    /**
     * Gets the fragment at the position from {@code mRegisteredFragments} and returns it, or null
     * if there is no fragment at the position.
     *
     * @param position position of fragment
     * @return fragment at {@code position}
     */
    public Fragment getRegisteredFragment(int position)
    {
        WeakReference<Fragment> reference = mRegisteredFragments.get(position);
        if (reference != null)
            return reference.get();
        else
            return null;
    }
}

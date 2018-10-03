package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import io.github.project_travel_mate.R;
import objects.Contributor;

/**
 * @author amoraitis
 */
public class ContributorsAdapter extends BaseAdapter {
    private final Context mContext;
    private List<Contributor> mContributors;

    public ContributorsAdapter(Context context, List<Contributor> contributors) {
        mContext = context;
        mContributors = contributors;
    }

    @Override
    public int getCount() {
        return mContributors.size();
    }

    @Override
    public Object getItem(int i) {
        return mContributors.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Contributor contributor = mContributors.get(position);
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.contributors_gridview_item, null);
        }

        final ImageView contributor_avatarImageView = (ImageView) convertView.findViewById(R.id.contributor_image);
        final TextView contributor_unameTextView = (TextView) convertView.findViewById(R.id.contributor_name);
        String contributorAvatarUrl = contributor.getAvatarUrl();
        Picasso.with(mContext).load(contributorAvatarUrl).placeholder(R.drawable.placeholder_image)
                .into(contributor_avatarImageView);
        contributor_unameTextView.setText(contributor.getUsername());

        return convertView;
    }

    public void update(ArrayList<Contributor> newContributors) {
        mContributors.clear();
        this.mContributors = newContributors;
        this.notifyDataSetChanged();
    }
}

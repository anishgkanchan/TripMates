package tripmates.enigma.com.tripmates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.makeramen.roundedimageview.RoundedImageView;

/**
 * Created by dnish on 11/30/2016.
 */
public class HistoryListAdapter extends BaseAdapter{
    PersonDetails[] data;
    LayoutInflater mInflater;
    Context context;
    HistoryListAdapter(PersonDetails[] data, Context context){
        this.data = data;
        this.context = context;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("getView " + position + " " + convertView);
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.people_listitem, null);
            holder = new ViewHolder();
            holder.name = (TextView)convertView.findViewById(R.id.txt_name);
            holder.dist = (TextView)convertView.findViewById(R.id.txt_dist);
            holder.img = (RoundedImageView) convertView.findViewById(R.id.img_person);
            holder.btnAdd = (ImageView) convertView.findViewById(R.id.img_add_person);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.name.setText(data[position].personName);
        holder.dist.setText(data[position].desc);
        holder.img.setImageBitmap(data[position].personImage);
        holder.btnAdd.setVisibility(View.GONE);
        return convertView;
    }

    class ViewHolder {
        TextView name,dist;
        RoundedImageView img;
        ImageView btnAdd;
        ViewHolder() {
        }

    }
}

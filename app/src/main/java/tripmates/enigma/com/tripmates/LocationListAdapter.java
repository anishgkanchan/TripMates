package tripmates.enigma.com.tripmates;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dnish on 10/16/2016.
 */
public class LocationListAdapter extends BaseAdapter {
    LocationData[] data;
    LayoutInflater mInflater;
    LocationListAdapter(LocationData[] data, Context context){
        this.data = data;
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
    public View getView(int position, View convertView, ViewGroup parent){
        System.out.println("getView " + position + " " + convertView);
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.location_listitem, null);
            holder = new ViewHolder();
            holder.name = (TextView)convertView.findViewById(R.id.txt_name);
            holder.dist = (TextView)convertView.findViewById(R.id.txt_dist);
            holder.img = (ImageView) convertView.findViewById(R.id.img_loc);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.name.setText(data[position].name);
        holder.dist.setText(data[position].distance+" miles");
        holder.img.setImageBitmap(data[position].img);
        return convertView;
    }

    class ViewHolder {
        TextView name,dist;
        ImageView img;
        ViewHolder() {
        }

    }
}

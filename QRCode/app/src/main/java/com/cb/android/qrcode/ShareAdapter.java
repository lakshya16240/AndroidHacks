package com.cb.android.qrcode;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by GhanshamBansal on 10/07/17.
 */

public class ShareAdapter extends RecyclerView.Adapter<ShareAdapter.ShareViewHolder> {

    Context context;
    ArrayList<Files> fileList;

    public ShareAdapter(Context context, ArrayList<Files> fileList) {
        this.context = context;
        this.fileList = fileList;
    }

    public void updateFileList (ArrayList<Files> files) {
        this.fileList = files;
        notifyDataSetChanged();
    }

    @Override
    public ShareViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_files,parent,false);
        return new ShareViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ShareViewHolder holder, int position) {
        Files file = fileList.get(position);
        holder.tv_fileType.setText(file.getType());
        holder.tv_fileName.setText(file.getName());


    }

    @Override
    public int getItemCount() {
        return fileList.size();
    }

    public class ShareViewHolder extends RecyclerView.ViewHolder{
        TextView tv_fileName,tv_fileType;
        public ShareViewHolder(View itemView) {
            super(itemView);
            tv_fileName = (TextView) itemView.findViewById(R.id.tv_fileName);
            tv_fileType = (TextView) itemView.findViewById(R.id.tv_fileType);
        }
    }
}

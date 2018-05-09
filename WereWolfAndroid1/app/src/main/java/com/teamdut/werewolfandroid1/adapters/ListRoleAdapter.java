package com.teamdut.werewolfandroid1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.teamdut.werewolfandroid1.R;
import com.teamdut.werewolfandroid1.models.Role;

import java.util.ArrayList;

public class ListRoleAdapter extends RecyclerView.Adapter<ListRoleAdapter.RecyclerViewHolder> {
    private Context context;
    private ArrayList<Role> listRole;

    private PositionClickListener listener;
    private int selectedPos = 0;

    public ListRoleAdapter(Context context, ArrayList<Role> listRole, PositionClickListener listener) {
        this.context = context;
        this.listRole = listRole;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_role, parent, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.roleImg.setImageResource(listRole.get(position).getImgRes());
        holder.roleName.setText(listRole.get(position).getName() + " (" + listRole.get(position).getScore() + ")");
        holder.textNumber.setText(listRole.get(position).getQuantity() + "");

        if (listRole.get(position).getQuantity() == 0) {
            holder.numberLayout.setVisibility(View.GONE);
        } else {
            holder.numberLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return listRole.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public interface PositionClickListener {
        void itemClicked(int position);
        void subClicked(int position);
        void plusClicked(int position);
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView roleImg;
        public TextView roleName;
        public TextView textNumber;
        public ImageView btnSub;
        public ImageView btnPlus;
        public RelativeLayout numberLayout;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            roleImg = (ImageView) itemView.findViewById(R.id.role_img);
            roleName = (TextView) itemView.findViewById(R.id.role_name);
            textNumber = (TextView) itemView.findViewById(R.id.text_number);
            btnSub = (ImageView) itemView.findViewById(R.id.btn_sub);
            btnPlus = (ImageView) itemView.findViewById(R.id.btn_plus);
            numberLayout = (RelativeLayout) itemView.findViewById(R.id.number_layout);

            itemView.setOnClickListener(this);
            btnSub.setOnClickListener(this);
            btnPlus.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                default:
                    listener.itemClicked(getLayoutPosition());
                    notifyItemChanged(selectedPos);
                    selectedPos = getLayoutPosition();
                    notifyItemChanged(selectedPos);
                    break;
                case R.id.btn_sub:
                    listener.subClicked(getLayoutPosition());
                    notifyItemChanged(selectedPos);
                    selectedPos = getLayoutPosition();
                    notifyItemChanged(selectedPos);
                    break;
                case R.id.btn_plus:
                    listener.plusClicked(getLayoutPosition());
                    notifyItemChanged(selectedPos);
                    selectedPos = getLayoutPosition();
                    notifyItemChanged(selectedPos);
                    break;
            }
        }
    }
}

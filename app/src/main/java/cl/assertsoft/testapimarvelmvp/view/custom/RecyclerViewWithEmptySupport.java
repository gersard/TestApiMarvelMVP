package cl.assertsoft.testapimarvelmvp.view.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import cl.assertsoft.testapimarvelmvp.R;

/**
 * Created by Gerardo on 12-06-2017.
 */

public class RecyclerViewWithEmptySupport extends RecyclerView {

    private TextView emptyView;

    public RecyclerViewWithEmptySupport(Context context) {
        super(context);
    }

    public RecyclerViewWithEmptySupport(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RecyclerViewWithEmptySupport(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private AdapterDataObserver emptyObserver = new AdapterDataObserver() {


        @Override
        public void onChanged() {
            Adapter<?> adapter =  getAdapter();
            if(adapter != null && emptyView != null) {
                if(adapter.getItemCount() == 0) {
                    emptyView.setVisibility(View.VISIBLE);
                    RecyclerViewWithEmptySupport.this.setVisibility(View.GONE);
                }
                else {
                    emptyView.setVisibility(View.GONE);
                    RecyclerViewWithEmptySupport.this.setVisibility(View.VISIBLE);
                }
            }

        }
    };


    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        if(adapter != null) {
            adapter.registerAdapterDataObserver(emptyObserver);
        }
        emptyObserver.onChanged();
    }

    public void setEmptyView(TextView textView) {
        this.emptyView = textView;
    }


}

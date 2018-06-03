package kk.techbytecare.recyclerviewanimation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;

import kk.techbytecare.recyclerviewanimation.Adapter.SimpleAdapter;

public class MainActivity extends AppCompatActivity {

    Button btnFallDown,btnSlideDown,btnRight,btnLeft;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        btnFallDown = findViewById(R.id.btnFallDown);
        btnSlideDown = findViewById(R.id.btnBottom);
        btnRight = findViewById(R.id.btnRight);
        btnLeft = findViewById(R.id.btnLeft);

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        btnFallDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runAnimation(recyclerView,0);
            }
        });

        btnSlideDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runAnimation(recyclerView,1);
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runAnimation(recyclerView,2);
            }
        });

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runAnimation(recyclerView,3);
            }
        });
    }

    private void runAnimation(RecyclerView recyclerView, int type) {
        Context context = recyclerView.getContext();

        LayoutAnimationController controller = null;

        if (type == 0)  {
            controller = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_fall_down);
        }
        else if (type == 1)  {
            controller = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_slide_from_bottom);
        }
        else if (type == 2)  {
            controller = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_slide_from_right);
        }
        else if (type == 3)  {
            controller = AnimationUtils.loadLayoutAnimation(context,R.anim.layout_slide_from_left);
        }
        SimpleAdapter adapter = new SimpleAdapter();
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
}

package com.example.oliku.my_image;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int index=0;
    ImageView img=null;
    int [] images={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=(ImageView)findViewById(R.id.imageView);
        img.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if((int)motionEvent.getRawX()>(int)view.getWidth()/2){
                    ++index;
                    if(index>images.length-1) {
                        index = 0;
                    }
                    img.setImageResource(images[index]);
                }
                else {
                    --index;
                    if(index<0) {
                        index = images.length-1;
                    }
                    img.setImageResource(images[index]);
                }


                return true;
            }
        });
        Button btnLeft=(Button)findViewById(R.id.btnLeft);
        Button btnRight=(Button)findViewById(R.id.btnRight);
        btnLeft.setOnClickListener(new OnClick());
        btnRight.setOnClickListener(new OnClick());
    }
    public class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {


            if(view.getId()==R.id.btnLeft){
                --index;
                if(index<0) {
                    index = images.length-1;
                }
                img.setImageResource(images[index]);
            }else if(view.getId()==R.id.btnRight){
                ++index;
                if(index>images.length-1) {
                    index = 0;
                }
                img.setImageResource(images[index]);


                }
            }

    }
}

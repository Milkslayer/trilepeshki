package com.example.flash;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final int CAMERA_REQUEST=1888;
    private Camera camera;
    Camera.Parameters param;
    Button btn;
    EditText et1;
    TextView tv1;
    private boolean Active=false;
    private boolean isFlash = false;
    private int dot = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, CAMERA_REQUEST);
        }
        if(getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)){
            camera = Camera.open();
            param = camera.getParameters();
            isFlash = true;
        }
        btn = (Button)findViewById(R.id.button);
        et1 = (EditText)findViewById(R.id.editText);
        tv1 = (TextView)findViewById(R.id.textView);
    }
    public void click(View v){
        if(isFlash){
            if(!Active){
                param.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(param);
                camera.startPreview();
                Active = true;
            } else {
                param.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera.setParameters(param);
                camera.stopPreview();
                Active = false;
            }
        } else {
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setMessage("NE RABOTAET");
            alert.show();
        }
    }
    public void read(View v) throws InterruptedException {
        String s = et1.getText().toString();
        char[] str = MorseTranslate.toMorze(s).toCharArray();
        tv1.setText(MorseTranslate.toMorze(s));
        MorseTranslate.Code(camera,param,str,dot);
    }
    @Override
    protected void onStop() {
        super.onStop();
        if(camera!=null){
            camera.release();
            camera = null;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    Toast.makeText(this, "Permission denied to read SMS", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    }
}

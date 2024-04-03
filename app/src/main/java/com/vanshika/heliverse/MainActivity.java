package com.vanshika.heliverse;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.vanshika.heliverse.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        adjustFontAndDisplayScale();
        binding.ageVerificationText.setTextSize(20);
        binding.continueAgreeText.setTextSize(20);
        binding.yesButton.setTextSize(18);
        binding.noBtn.setTextSize(18);

        int widthInDp = 170;
        int heightInDp = 400;


        float scale = getResources().getDisplayMetrics().density;
        int widthInPixels = (int) (widthInDp * scale + 300.5f);
        int heightInPixels = (int) (heightInDp * scale + 955.5f);

        binding.girl.getLayoutParams().width = widthInPixels;
        binding.girl.getLayoutParams().height = heightInPixels;
        binding.girl.requestLayout();

    }
    private void adjustFontAndDisplayScale() {
        Configuration configuration = getResources().getConfiguration();
        if (configuration.fontScale != 1.0 || configuration.densityDpi != DisplayMetrics.DENSITY_DEFAULT) {
            configuration.fontScale = 3.0f;
            configuration.densityDpi = DisplayMetrics.DENSITY_DEFAULT;
            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            metrics.scaledDensity = configuration.fontScale * metrics.density;
            getBaseContext().getResources().updateConfiguration(configuration, metrics);
        }
    }


}
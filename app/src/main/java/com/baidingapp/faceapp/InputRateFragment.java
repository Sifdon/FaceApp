package com.baidingapp.faceapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class InputRateFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_input_rate, container, false);


        // Upload and show face image
        ImageView mFaceImageView = (ImageView) view.findViewById(R.id.photo_input_rate);

        // The URL is used to test Picasso
        String imageUrl = "http://www.fdsm.fudan.edu.cn/UserWebEditorUploadImage/upload/image/20160428/6359744927934022586120687.jpg";

        Picasso.with(getActivity()).load(imageUrl)
                // show the resource image while downloading images
                .placeholder(R.drawable.face_image)
                // show the resource image if there is an error in downloading images
                .error(R.drawable.face_image)
                .into(mFaceImageView);


        // onCLick the "result" button
        Button mResultButton = (Button) view.findViewById(R.id.action_show_result);
        mResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the results

                // Plot the rates by others
                BarChart mBarChart = (BarChart) view.findViewById(R.id.input_rate_bar_chart);

                List<BarEntry> barEntries = new ArrayList<>();
                barEntries.add(new BarEntry(1f, 0.05f));
                barEntries.add(new BarEntry(2f, 0.1f));
                barEntries.add(new BarEntry(3f, 0.1f));
                barEntries.add(new BarEntry(4f, 0.33f));
                barEntries.add(new BarEntry(5f, 0.17f));
                barEntries.add(new BarEntry(6f, 0.05f));
                barEntries.add(new BarEntry(7f, 0.05f));
                barEntries.add(new BarEntry(8f, 0.05f));
                barEntries.add(new BarEntry(9f, 0.05f));
                barEntries.add(new BarEntry(10f, 0.05f));

                BarDataSet barDataSet = new BarDataSet(barEntries, "别人眼中的TA：");
                BarData theData = new BarData(barDataSet);
                mBarChart.setDescription(null);
                // mBarChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
                mBarChart.setData(theData);
                mBarChart.animateY(1000);
                mBarChart.invalidate();

            }
        });


        return view;
    }

}
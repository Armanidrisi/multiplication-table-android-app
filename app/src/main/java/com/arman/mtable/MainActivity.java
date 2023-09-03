package com.arman.mtable;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class MainActivity extends Activity {
    private ListView listView;
    private SeekBar seekBar;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      
        listView = findViewById(R.id.table);
        seekBar = findViewById(R.id.seek_bar);

        final ArrayList<String> table = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, table);
        listView.setAdapter(adapter);

		generateMultiplicationTable(table,2); 
		
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
				@Override
				public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
					// Handle SeekBar progress change here
					generateMultiplicationTable(table, progress);
					adapter.notifyDataSetChanged();
				}

				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
				}

				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
				}
			});
    }

    // Method to generate the multiplication table based on the SeekBar progress
    private void generateMultiplicationTable(ArrayList<String> table, int progress) {
        table.clear();
        if (progress > 0 && progress <= 40) {
            for (int i = 1; i <= 10; i++) {
                int result = i * progress;
                table.add(progress + " x " + i + " = " + result);
            }
        }
    }
}

package edu.sjsu.shubhushahade.exercise1shubhushahade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText text;
    private RadioButton celsiusButton;
    private RadioButton fahrenheitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.EditText);
        celsiusButton = findViewById(R.id.radioButton);
        fahrenheitButton = findViewById(R.id.radioButton2);
    }

    public void onClick(View view) {
        // Toast a message for empty entry
        if (text.getText().length() == 0) {
            Toast.makeText(this, "Please enter a valid number",
                    Toast.LENGTH_LONG).show();
            return; }
        // Get the input value from the text box
        float inputValue = Float.parseFloat(text.getText().toString());
        if (celsiusButton.isChecked()) {
            // Set the text box to be the result of conversion
            text.setText(String.valueOf(ConverterUtil.
                    convertFahrenheitToCelsius(inputValue)));
            // Switch to the other option
            celsiusButton.setChecked(false);
            fahrenheitButton.setChecked(true);
        } else {
            text.setText(String.valueOf(ConverterUtil.
                    convertCelsiusToFahrenheit(inputValue)));
            fahrenheitButton.setChecked(false);
            celsiusButton.setChecked(true);
        }
    }
}
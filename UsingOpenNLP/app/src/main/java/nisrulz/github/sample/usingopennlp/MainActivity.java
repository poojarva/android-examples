package nisrulz.github.sample.usingopennlp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import nisrulz.github.sample.usingopennlp.opennlp.SentenceDetector;

public class MainActivity extends AppCompatActivity {

  private EditText editText;
  private TextView textView;
  private Button button;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initView();
  }

  private void initView() {
    editText = (EditText) findViewById(R.id.editText);
    textView = (TextView) findViewById(R.id.textView);
    button = (Button) findViewById(R.id.button);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (!TextUtils.isEmpty(editText.getText().toString())) {
          String[] sentences = new SentenceDetector().findSentences(MainActivity.this,
              editText.getText().toString());
          String finalData = "";
          for (int i = 0; i < sentences.length; i++) {
            finalData += sentences[i] + "\n";
          }

          textView.setText(finalData);
        }
      }
    });
  }
}
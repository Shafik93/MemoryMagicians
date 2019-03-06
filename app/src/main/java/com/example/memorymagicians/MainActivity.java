package com.example.memorymagicians;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatDrawableManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity{


    private ImageButton imageButton0,imageButton1,imageButton2,imageButton3,imageButton4,imageButton5,
            imageButton6,imageButton7,imageButton8,imageButton9,imageButton10,imageButton11,firstButtonSelected;

    private Button resetButton;

    private EditText matchesOutput, triesOutput;

    private int index1, index2, counterMatch = 0, counterUnmatch = 0, numberOfImages = 6;
    private boolean firstSelected=false, secondSelected=false;

    private int unmatchColor = R.color.red, matchColor = R.color.purple;


    int [] images= {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define controllers
        imageButton0 = findViewById(R.id.imageButton0);
        imageButton1 = findViewById(R.id.imageButton1);
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton3 = findViewById(R.id.imageButton3);
        imageButton4 = findViewById(R.id.imageButton4);
        imageButton5 = findViewById(R.id.imageButton5);
        imageButton6 = findViewById(R.id.imageButton6);
        imageButton7 = findViewById(R.id.imageButton7);
        imageButton8 = findViewById(R.id.imageButton8);
        imageButton9 = findViewById(R.id.imageButton9);
        imageButton10 = findViewById(R.id.imageButton10);
        imageButton11 = findViewById(R.id.imageButton11);

        resetButton = findViewById(R.id.reset);

        matchesOutput = findViewById(R.id.matchesOutput);
        triesOutput = findViewById(R.id.triesOutput);

        //set tags to the image buttons
        imageButton0.setTag("0");
        imageButton1.setTag("1");
        imageButton2.setTag("2");
        imageButton3.setTag("3");
        imageButton4.setTag("4");
        imageButton5.setTag("5");
        imageButton6.setTag("6");
        imageButton7.setTag("7");
        imageButton8.setTag("8");
        imageButton9.setTag("9");
        imageButton10.setTag("10");
        imageButton11.setTag("11");



        //set the unmatched color to buttons
        imageButton0.setImageResource(unmatchColor);
        imageButton1.setImageResource(unmatchColor);
        imageButton2.setImageResource(unmatchColor);
        imageButton3.setImageResource(unmatchColor);
        imageButton4.setImageResource(unmatchColor);
        imageButton5.setImageResource(unmatchColor);
        imageButton6.setImageResource(unmatchColor);
        imageButton7.setImageResource(unmatchColor);
        imageButton8.setImageResource(unmatchColor);
        imageButton9.setImageResource(unmatchColor);
        imageButton10.setImageResource(unmatchColor);
        imageButton11.setImageResource(unmatchColor);


        //shuffle image array
        shuffleLocation();

        //set listener for controller

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBoard();
            }
        });

        imageButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matchImage(v, imageButton0);
            }
        });
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matchImage(v, imageButton1);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matchImage(v, imageButton2);
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matchImage(v, imageButton3);
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matchImage(v, imageButton4);
            }
        });
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matchImage(v, imageButton5);
            }
        });
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matchImage(v, imageButton6);
            }
        });
        imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matchImage(v, imageButton7);
            }
        });
        imageButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matchImage(v, imageButton8);
            }
        });
        imageButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matchImage(v, imageButton9);
            }
        });
        imageButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matchImage(v, imageButton10);
            }
        });
        imageButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matchImage(v, imageButton11);
            }
        });


    }

    //set Unmatched Color cells
    protected void changeUnmatchedColor(View view){
        // Get checked status
        boolean checked = ((RadioButton) view).isChecked();

        // Test which radio button changed
        switch(view.getId())
        {
            case R.id.red:
                if (checked) {
                    unmatchColor = R.color.red;
                    resetBoard();
                }
                break;
            case R.id.blue:
                if (checked) {
                    unmatchColor = R.color.blue;
                    resetBoard();
                }
                break;
            case R.id.yellow:
                if (checked) {
                    unmatchColor = R.color.yellow;
                    resetBoard();
                }
                break;
        }

    }

    //set matched Color cells
    protected void changeMatchedColor(View view){
// Get checked status
        boolean checked = ((RadioButton) view).isChecked();

        // Test which radio button changed
        switch(view.getId())
        {
            case R.id.purple:
                if (checked) {
                    matchColor = R.color.purple;
                    resetBoard();
                }
                break;
            case R.id.orange:
                if (checked) {
                    matchColor = R.color.orange;
                    resetBoard();
                }
                break;
            case R.id.green:
                if (checked) {
                    matchColor = R.color.green;
                    resetBoard();
                }
                break;
        }

    }


    //shuffle image array
    protected void shuffleLocation(){
        Random rand = new Random();
        int temp, swap;
        for(int i=0; i<numberOfImages; i++){
            temp = images[i];
            swap = rand.nextInt(numberOfImages);
            images[i] = images[swap];
            images[swap] = temp;
        }


    }

    //rest the board
    protected void resetBoard(){
        Toast toast;
        String message = "The board has been reset";
        shuffleLocation();
        counterMatch = counterUnmatch = 0;
        firstSelected = secondSelected = false;
        triesOutput.setText("");
        matchesOutput.setText("");

        imageButton0.setImageResource(unmatchColor);
        imageButton1.setImageResource(unmatchColor);
        imageButton2.setImageResource(unmatchColor);
        imageButton3.setImageResource(unmatchColor);
        imageButton4.setImageResource(unmatchColor);
        imageButton5.setImageResource(unmatchColor);
        imageButton6.setImageResource(unmatchColor);
        imageButton7.setImageResource(unmatchColor);
        imageButton8.setImageResource(unmatchColor);
        imageButton9.setImageResource(unmatchColor);
        imageButton10.setImageResource(unmatchColor);
        imageButton11.setImageResource(unmatchColor);

        imageButton0.setEnabled(true);
        imageButton1.setEnabled(true);
        imageButton2.setEnabled(true);
        imageButton3.setEnabled(true);
        imageButton4.setEnabled(true);
        imageButton5.setEnabled(true);
        imageButton6.setEnabled(true);
        imageButton7.setEnabled(true);
        imageButton8.setEnabled(true);
        imageButton9.setEnabled(true);
        imageButton10.setEnabled(true);
        imageButton11.setEnabled(true);

        toast = Toast.makeText(getApplicationContext(),
                message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }


    //control the game
    protected void matchImage(View v, final ImageButton ib) {
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());


        //if the first button is clicked
        if(!firstSelected) {
            firstButtonSelected = ib;
            index1 = Integer.parseInt((String) ib.getTag()) % numberOfImages;
            ib.setImageResource(images[index1]);
            firstSelected =true;

        }
        //if same button selected
        if(firstButtonSelected.getId() == ib.getId())
            return;

        //if the second button is clicked
        else if(!secondSelected){
            index2 = Integer.parseInt((String) ib.getTag()) % numberOfImages;
            ib.setImageResource(images[index2]);
            secondSelected = true;

            triesOutput.setText(""+(++counterUnmatch));

            //check if it's a match
            if(images[index1] == images[index2]){
                firstButtonSelected.setEnabled(false);
                ib.setEnabled(false);

                if(counterMatch == numberOfImages-1){
                    //dialog message
                    builder.setTitle(" Message");
                    builder.setMessage("Game Over!!");
                    builder.setPositiveButton("OK", null);
                    builder.show();
                }

                //dialog message
                builder.setTitle(" Message");
                builder.setMessage("Matched Cells");
                builder.setPositiveButton("OK", null);
                builder.show();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        firstButtonSelected.setImageResource(matchColor);
                        ib.setImageResource(matchColor);
                        firstSelected =secondSelected =false;
                        matchesOutput.setText(""+(++counterMatch));
                    }
                }, 500);



            }

            //if not a match
            else {
                //dialog message
                builder.setTitle(" Message");
                builder.setMessage("Unmatched Cells");
                builder.setPositiveButton("OK", null);
                builder.show();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        firstSelected = secondSelected = false;
                        firstButtonSelected.setImageResource(unmatchColor);
                        ib.setImageResource(unmatchColor);
                    }
                }, 500);


            }

        }

    }


}


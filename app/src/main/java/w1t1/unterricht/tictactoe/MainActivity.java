    package w1t1.unterricht.tictactoe;

    import androidx.appcompat.app.AppCompatActivity;

    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.Toast;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener
    {
        Button f11, f12, f13, f21, f22, f23, f31, f32, f33;
        String xo = "X";
        int[][] gameStorage;
        boolean noWinner = false;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            f11 = (Button) findViewById(R.id.field_1_1);
            f12 = (Button) findViewById(R.id.field_1_2);
            f13 = (Button) findViewById(R.id.field_1_3);
            f21 = (Button) findViewById(R.id.field_2_1);
            f22 = (Button) findViewById(R.id.field_2_2);
            f23 = (Button) findViewById(R.id.field_2_3);
            f31 = (Button) findViewById(R.id.field_3_1);
            f32 = (Button) findViewById(R.id.field_3_2);
            f33 = (Button) findViewById(R.id.field_3_3);

            f11.setOnClickListener(this);
            f12.setOnClickListener(this);
            f13.setOnClickListener(this);
            f21.setOnClickListener(this);
            f22.setOnClickListener(this);
            f23.setOnClickListener(this);
            f31.setOnClickListener(this);
            f32.setOnClickListener(this);
            f33.setOnClickListener(this);
            gameStorage = new int[3][3];
        }

        @Override
        public void onClick(View v)
        {
            switch (v.getId()){
                case R.id.field_1_1:
                    if (handleInput(1,1))
                    {
                        f11.setText(xo);
                    }
                    break;
                case R.id.field_1_2:
                    if (handleInput(1,2))
                    {
                        f12.setText(xo);
                    }
                    break;
                case R.id.field_1_3:
                    if (handleInput(1,3))
                    {
                        f13.setText(xo);
                    }
                    break;
                case R.id.field_2_1:
                    if (handleInput(2,1))
                    {
                        f21.setText(xo);
                    }
                    break;
                case R.id.field_2_2:
                    if (handleInput(2,2))
                    {
                        f22.setText(xo);
                    }
                    break;
                case R.id.field_2_3:
                    if (handleInput(2,3))
                    {
                        f23.setText(xo);
                    }
                    break;
                case R.id.field_3_1:
                    if (handleInput(3,1))
                    {
                        f31.setText(xo);
                    }
                    break;
                case R.id.field_3_2:
                    if (handleInput(3,2))
                    {
                        f32.setText(xo);
                    }
                    break;
                case R.id.field_3_3:
                    if (handleInput(3,3))
                    {
                        f33.setText(xo);
                    }
                    break;
            }
            if (checkGameEnd()){
                finishGame();
            }
        }
        private boolean handleInput(int x, int y)
        {
            boolean fieldFree = false;

            if (gameStorage[x-1][y-1] == 0)
            {
                if (xo.equals("X"))
                {
                    gameStorage[x-1][y-1] = 1;
                    xo = "O";
                }
                else
                {
                    gameStorage[x-1][y-1] =-1;
                    xo = "X";
                }
                fieldFree = true;
            }
            return fieldFree;
        }
        private boolean checkGameEnd()
        {
            int usedField = 0;
            for (int x = 0; x <= 2; x++)
            {
                for (int y = 0; y <= 2 ; y++)
                {
                    usedField = usedField + (Math.abs(gameStorage[x][y]));
                }
            }
            if (usedField == 9)
            {
                noWinner = true;
            }

               return (Math.abs(gameStorage[0][0] + gameStorage[0][1]+gameStorage[0][2]) == 3
                    || Math.abs(gameStorage[1][0] + gameStorage[1][1]+gameStorage[1][2]) == 3
                    || Math.abs(gameStorage[2][0] + gameStorage[2][1]+gameStorage[2][2]) == 3
                    || Math.abs(gameStorage[0][0] + gameStorage[1][0]+gameStorage[2][0]) == 3
                    || Math.abs(gameStorage[0][1] + gameStorage[1][1]+gameStorage[2][1]) == 3
                    || Math.abs(gameStorage[0][2] + gameStorage[1][2]+gameStorage[2][2]) == 3
                    || Math.abs(gameStorage[0][0] + gameStorage[1][1]+gameStorage[2][2]) == 3
                    || Math.abs(gameStorage[0][2] + gameStorage[1][1]+gameStorage[2][0]) == 3)
                    || noWinner;
        }
        private void finishGame()
        {
            if (noWinner)
            {
                Toast.makeText(getApplicationContext(),"BERABERE", Toast.LENGTH_LONG).show();
            }
            else if (xo.equals("X"))
            {
                Toast.makeText(getApplicationContext(), "X KAZANDI", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "O KAZANDI", Toast.LENGTH_LONG).show();
            }
            Intent intent =  new Intent(this, MainActivity.class);
            startActivity(intent);
            this.finish();
        }
    }
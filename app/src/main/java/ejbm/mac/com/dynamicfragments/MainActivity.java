package ejbm.mac.com.dynamicfragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    View view ;


    FragmentManager fm ;
    FragmentTransaction ft ;
    Fragment f1 ;
    Fragment f2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Creation of fragments on Create
        f1 = new df1() ;
        f2 = new df2() ;

        // Add the fragments, leave 'em detached
        fm = getFragmentManager()  ;
        ft = fm.beginTransaction() ;

        ft.add( f1 , "Fragment1" )  ;
        ft.add( f2 , "Fragment2" ) ;
        ft.attach(f1);
        ft.attach( f2 ) ;


        ft.commit() ;
    }

    public void loadFr1(View view) {
        //f1 = new df1() ;

/*        FragmentTransaction ft = fm.beginTransaction() ;

        //ft.add( null ) ;;

        ft.replace( R.id.layout4Fragments, f1 , "TAG_Frg1" ) ;

        //ft.remove( null ) ;;

        // ft.attach( f1 ) ;

        Log.d( "EJBM" , "???: " + ft.isAddToBackStackAllowed()  ) ;
*/

        ft.attach(f1) ;
        ft.detach(f2) ;

        //ft.hide(f1) ;
        //ft.hide(f2) ;
        //ft.commit() ;

    }

    public void loadFr2(View view) {

/*        f2 = new df2() ;

        FragmentTransaction ft = fm.beginTransaction() ;

        ft.replace( R.id.layout4Fragments, f2 , "TAG_Frg1" ) ;
*/

        ft.attach( f2 ) ;
        ft.detach( f1 ) ;


        //ft.hide(f2) ;
        //ft.hide(f1) ;
        //ft.commit() ;
    }
}

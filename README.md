# ProgressScreen
Progress Screen overlay that stops input

To use this add 

	<include layout="@layout/progress_bar"/>
	
either inside a RelativeLayout or Contraint Layout


	<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    	xmlns:app="http://schemas.android.com/apk/res-auto"
    	xmlns:tools="http://schemas.android.com/tools"
    	android:id="@+id/messages_main_holder"
    	android:layout_width="match_parent"
    	android:layout_height="match_parent">


    	<android.support.v7.widget.RecyclerView
        android:id="@+id/content_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

    	</android.support.v7.widget.RecyclerView>


    	<include layout="@layout/progress_bar"/>

	</android.support.constraint.ConstraintLayout>


The code to activiate it:

Java:
  
	ProgressScreen progressBar = new ProgressScreen(thisActivity);
	
	progressBar.on()
	
	progressBar.off() 
	

Kotlin:

	ProgressScreen(thisActivity).on()
	ProgressScreen(thisActivity).off()
	
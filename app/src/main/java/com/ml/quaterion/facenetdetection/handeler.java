package com.ml.quaterion.facenetdetection;

import static android.content.Intent.getIntent;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class handeler {
    static long lastdate=0;
   private static String DirectoryName="";
    private static File filepath;


   static void setDirectory(String dname){
       DirectoryName=dname;
   }
   static Set<String> fetchData(){
       Set<String> st=new HashSet<String>();

           File root_class = new File(Environment.getExternalStoragePublicDirectory
                   (Environment.DIRECTORY_DOCUMENTS),"FinalProjectAttendance"+"/"+DirectoryName);

           Log.d("numberu",root_class.getAbsolutePath());

            filepath = new File(root_class,"DSA"+new SimpleDateFormat("MM_dd_yyyy").format(new Date())+".txt");
           if(!root_class.exists())   root_class.mkdirs();
               BufferedReader reader=null;
               try {
                    reader = new BufferedReader(new java.io.FileReader(filepath));

               String line="";
               while ((line=reader.readLine())!=null){
                   st.add(line);
               }
               reader.close();
               }catch (Exception e){
                   return st;
               }

      return st;
   }


  static void arengeSet(Set<String> st){
       Date date=new Date();
       if(date.getTime() -lastdate>10000  && !st.isEmpty()){
           //Toast.makeText(getC,)
           Log.d("number", st +" "+lastdate);
           String pattern = "E, dd MMM yyyy HH:mm:ss z";
           String pat="MM_dd_yyyy";
           SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
           Log.d("Time",simpleDateFormat.format(date));
           lastdate=date.getTime();

           try{


               FileWriter writer = new FileWriter(filepath);
               for(String s:st){
                   writer.append(s).append("\n");
               }



               writer.flush();
           } catch (IOException e) {
               throw new RuntimeException(e);
           }

       }

    }
}

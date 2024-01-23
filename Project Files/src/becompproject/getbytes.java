
package becompproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class getbytes {
    
    public int getDataByte(){
    BufferedReader reader;
    int i;
    int DataByte = 0;
    char[] dByte = new char[100];
    try {
        reader = new BufferedReader(new FileReader(
          "C:/Users/Public/Documents/BeCompProject_v6/src/becompproject/pacSys/analysis.txt"));
        String l = reader.readLine();
        reader.skip(21);
        reader.read(dByte, 0, 5);
        for(i=0; dByte[i]!='\0'; i++){
          if((dByte[i]>='0')&&(dByte[i]<='9')){
            DataByte = DataByte*10 + (int)dByte[i]-48;
          }
          else continue;
        }
        reader.close();
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    return DataByte;
  }

  public double getAvgPkt(){
    BufferedReader reader;
    int i;
    double AvgPktSz = 0;
    char[] APSize = new char[100];
    try {
      reader = new BufferedReader(new FileReader(
        "C:/Users/Public/Documents/BeCompProject_v6/src/becompproject/pacSys/analysis.txt"));
      String l = reader.readLine();
      l = reader.readLine();
      reader.skip(21);
      reader.read(APSize, 0, 5);
      for(i=0; APSize[i]!='\0'; i++){
        if(APSize[i]=='.')
          break;
        if((APSize[i]>='0')&&(APSize[i]<='9'))
          AvgPktSz = AvgPktSz*10 + (int)APSize[i]-48;
        else continue;
      }
      reader.close();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return AvgPktSz;
  }

  public double getAvgRt(){
    BufferedReader reader;
    int i;
    double AvgPktRt = 0;
    char[] APRate = new char[100];
    try {
      reader = new BufferedReader(new FileReader(
        "C:/Users/Public/Documents/BeCompProject_v6/src/becompproject/pacSys/analysis.txt"));
      String l = reader.readLine();
      l = reader.readLine();
      l = reader.readLine();
      reader.skip(21);
      reader.read(APRate, 0, 5);
      for(i=0; APRate[i]!='\0'; i++){
        if(APRate[i]=='.')
          break;
        if((APRate[i]>='0')&&(APRate[i]<='9'))
          AvgPktRt = AvgPktRt*10 + (int)APRate[i]-48;
        else continue;
      }
      reader.close();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return AvgPktRt;
  }
}

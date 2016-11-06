
package main;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags({"ScannerBean"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"ScannedString"})
@EditablePropertyNames({"ScannedString"})
public class StringScanner 
{
	private String scannedString;
	public String getScannedString()
	{
		return scannedString;
	}
	public void setScannedString(String s)
	{
		scannedString=s;
		scanString(scannedString);
	}
	
	public static int indexOf(String s,char ch,int fromIndex)
	{
		for(int i=fromIndex;i<s.length();i++)
		{
			if(s.charAt(i)==ch)
				return i;
		}
		return -1;
	}
	public static void scanString(String s)
	{
		int placeHolder=-1;
		String output="";
		while(indexOf(s,' ',placeHolder+1)!=-1)
		{
			if(s.charAt(placeHolder+1)=='"')
			{
				output+="Quoted String:"+s.substring(placeHolder+2, indexOf(s,'"',placeHolder+2))+"\n";
			}
			else if(Character.isDigit(s.charAt(placeHolder+1)))
			{
				output+="Number:"+s.substring(placeHolder+1, indexOf(s,' ',placeHolder+1))+"\n";
			}
			else
			{
				output+="Word:"+s.substring(placeHolder+1, indexOf(s,' ',placeHolder+1))+"\n";
			}
			if(s.charAt(placeHolder+1)=='"'&& s.substring(placeHolder+2,indexOf(s,'"',placeHolder+2)).contains(" "))
				placeHolder=indexOf(s,'"',placeHolder+2);
			else
				placeHolder=indexOf(s,' ',placeHolder+1);
		}
		System.out.println(output);
	}
}

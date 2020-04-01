package toPdf;
	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2017年12月20日 下午4:32:18
 * @version 1.0 
 * @parameter 
 * @since  
 * @return  */
public class ExtITextFontRegistry extends ExtAbstractFontRegistry {
	 public static ExtITextFontRegistry getRegistry()
	   {
	       return INSTANCE;
	   }
	   
	   @Override
	   protected String resolveFamilyName(String familyName, int style)
	   {
	       return familyName;
	   }

	   private static final ExtITextFontRegistry INSTANCE = new ExtITextFontRegistry();
}

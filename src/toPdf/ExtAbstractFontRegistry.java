package toPdf;
	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2017年12月20日 下午4:33:26
 * @version 1.0 
 * @parameter 
 * @since  
 * @return  */
public abstract  class ExtAbstractFontRegistry extends AbstractFontRegistry{
	public static FontFactoryImp extFontFactoryImp = new ExtFontFactoryImp();

	   public ExtAbstractFontRegistry()
	   {
	     FontFactory.setFontImp(extFontFactoryImp);
	   }
}

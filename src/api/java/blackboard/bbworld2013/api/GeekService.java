package blackboard.bbworld2013.api;

import blackboard.base.IFactory;
import blackboard.platform.extension.util.ExtensionIFactory;

public interface GeekService
{

  public static final IFactory<GeekService> Factory = ExtensionIFactory.getFactory( GeekService.class, "blackboard.bbworld2013.api.geekService", false );
  
  public String getGeekPhrases( String phrase );
  
}

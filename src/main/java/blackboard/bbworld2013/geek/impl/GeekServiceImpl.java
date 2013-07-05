package blackboard.bbworld2013.geek.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import blackboard.base.IMultiFactory;
import blackboard.bbworld2013.api.GeekService;
import blackboard.bbworld2013.api.Geekifier;
import blackboard.platform.spring.beans.annotations.Extension;

@Component
@Extension( "blackboard.bbworld2013.api.geekService" )
public class GeekServiceImpl implements GeekService
{
  
  private IMultiFactory<Geekifier> _factory;
  
  @Autowired
  public GeekServiceImpl( IMultiFactory<Geekifier> factory )
  {
    _factory = factory;
  }

  @Override
  public String getGeekPhrases( String phrase )
  {
    StringBuilder str = new StringBuilder( phrase );
    str.append( "\n" );
    
    Collection<Geekifier> geeks = _factory.getInstances();
    for ( Geekifier geek : geeks )
    {
      str.append( geek.toGeekPhrase( phrase ) ).append( "\n" );
    }
    
    return str.toString();
  }

}

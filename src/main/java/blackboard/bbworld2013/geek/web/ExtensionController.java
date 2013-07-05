package blackboard.bbworld2013.geek.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import blackboard.base.IMultiFactory;
import blackboard.bbworld2013.api.Geekifier;

@Controller
public class ExtensionController
{
  
  private IMultiFactory<Geekifier> _factory;
  
  @Autowired
  public ExtensionController( IMultiFactory<Geekifier> factory )
  {
    _factory = factory;
  }
  
  @RequestMapping( "/geek" )
  public ModelAndView get( @RequestParam( value = "p", defaultValue = "Hello World!" ) String phrase )
  {
    StringBuilder str = new StringBuilder( phrase );
    str.append( "<br/>" );
    
    Collection<Geekifier> geeks = _factory.getInstances();
    for ( Geekifier geek : geeks )
    {
      str.append( geek.toGeekPhrase( phrase ) ).append( "<br/>" );
    }
    
    return new ModelAndView( "geek", "phrases", str.toString() );
  }

}

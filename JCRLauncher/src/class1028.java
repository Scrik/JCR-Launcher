import java.lang.reflect.InvocationTargetException;

import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.HyperlinkEvent.EventType;

class class1028 implements HyperlinkListener
{
	// $FF: synthetic field
	final class1033 entry0;
	
	class1028(class1033 var1)
	{
		entry0 = var1;
	}
	
	@Override public final void hyperlinkUpdate(HyperlinkEvent var1)
	{
		if(var1.getEventType() == EventType.ACTIVATED)
		{
			try
			{
				class100.entry1004(var1.getURL().toString());
			} catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		}
	}
}

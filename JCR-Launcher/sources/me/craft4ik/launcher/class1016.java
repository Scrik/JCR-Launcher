package me.craft4ik.launcher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

final class class1016 implements ActionListener
{
	@Override public final void actionPerformed(ActionEvent var1)
	{
		if(LauncherAuthPanel.entry1005)
		{
			LauncherUtils.entry1007();
		} else
		{
			System.exit(0);
		}
	}
}

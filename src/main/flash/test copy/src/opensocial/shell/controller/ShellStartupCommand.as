package opensocial.shell.controller
{
	import flash.utils.getQualifiedClassName;
	
	import org.osflash.thunderbolt.Logger;
	import org.puremvc.as3.multicore.interfaces.INotification;
	import org.puremvc.as3.multicore.utilities.fabrication.patterns.command.SimpleFabricationCommand;
	
	public class ShellStartupCommand extends SimpleFabricationCommand
	{
		public static var NAME:String = getQualifiedClassName(ShellStartupCommand);
		
		override public function execute(note:INotification):void
		{
			Logger.info(NAME+ " : execute()");	
		}

	}
}
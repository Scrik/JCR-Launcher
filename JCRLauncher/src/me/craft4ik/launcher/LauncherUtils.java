package me.craft4ik.launcher;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class LauncherUtils
{
	public static class1044 entry0;
	public static final class10 entry1 = new class10("config", entry1003());
	public static String[] entry10 = null;
	public static boolean errorLoading = false;
	public static BufferedImage entry1000;
	public static BufferedImage entry1001;
	public static BufferedImage entry1002;
	public static BufferedImage entry1003;
	public static BufferedImage entry1004;
	public static BufferedImage entry1005;
	public static BufferedImage entry1006;
	public static BufferedImage entry1007;
	public static BufferedImage entry1008;
	public static BufferedImage entry1009;
	public static BufferedImage entry101;
	public static BufferedImage entry1010;
	public static BufferedImage entry1011;
	public static BufferedImage entry1012;
	public static BufferedImage entry1013;
	public static BufferedImage entry1014;
	public static BufferedImage entry1015;
	
	public static final void delete(File file)
	{
		try
		{
			if(!file.exists()) return;
			if(file.isDirectory())
			{
				File[] files = file.listFiles();
				for(File file2 : files)
				{
					delete(file2);
				}
			}
			file.delete();
		} catch(Exception var5)
		{
			LauncherAuthFrame.error("Удаление не удалось: " + file.toString());
		}
	}
	
	public static final void entry0(BufferedImage var0, int var1)
	{
		if(var0 == null && var1 == -1)
		{
			entry1000 = loadLocalImage(getSettings().getFaviconImage());
			entry1001 = loadLocalImage(getSettings().getBackgroundImage());
			entry1002 = loadLocalImage(getSettings().getLogotypeImage());
			entry1003 = loadLocalImage(getSettings().getAuthElementsImage());
			entry1004 = loadLocalImage(getSettings().getFrameIconsImage());
			entry1005 = loadLocalImage(getSettings().getButtonsImage());
			entry1006 = loadLocalImage(getSettings().getComboboxImage());
			entry1007 = loadLocalImage(getSettings().getCheckboxImage());
			entry1008 = loadLocalImage(getSettings().getFieldBackgroundImage());
			entry1009 = loadLocalImage(getSettings().getProgressbarImage());
			entry101 = loadLocalImage(getSettings().getModalBackgroundImage());
			entry1010 = loadLocalImage(getSettings().getNewsBackgroundImage());
			entry1011 = loadLocalImage(getSettings().getPressedBorderImage());
			entry1012 = loadLocalImage(getSettings().getWaitAntimationImage());
			entry1013 = loadLocalImage(getSettings().getAlertIconsImage());
			entry1014 = loadLocalImage(getSettings().getBandColorsImage());
		} else
		{
			switch(var1)
			{
				case 0:
					entry1000 = var0;
				case 1:
					entry1001 = var0;
				case 2:
					entry1002 = var0;
				case 3:
					entry1003 = var0;
				case 4:
					entry1004 = var0;
				case 5:
					entry1005 = var0;
				case 6:
					entry1006 = var0;
				case 7:
					entry1007 = var0;
				case 8:
					entry1008 = var0;
				case 9:
					entry1009 = var0;
				case 10:
					entry101 = var0;
				case 11:
					entry1010 = var0;
				case 12:
					entry1011 = var0;
				case 13:
					entry1012 = var0;
				case 14:
					entry1013 = var0;
				case 15:
					entry1014 = var0;
				default:
					break;
			}
		}
		entry1015 = loadLocalImage("char.png");
	}
	
	public static final void entry0(LauncherAuthFrame var0) throws UnsupportedEncodingException
	{
		String var1 = class1000.entry1(entry1001("login"));
		if(!var1.equals(""))
		{
			var0.entry1007.setText(var1);
		}
		String var2 = class1000.entry1(entry1001("password"));
		if(!var2.isEmpty())
		{
			var0.entry1008.setText(var2);
		}
		int var5 = entry1003("server");
		if(entry10 != null && var5 <= entry10.length)
		{
			var0.entry1004.entry0(var5);
		}
		int var3 = entry1003("remember");
		if(var3 != 0 && var3 != 1)
		{
			var0.entry1015.setSelected(false);
		} else
		{
			var0.entry1015.setSelected(true);
		}
		var0.entry1017.setSelected(entry1002("full_screen"));
		int var4 = entry1003("memory");
		if(var4 >= 256)
		{
			var0.entry1019.setText(var4 + "");
		}
	}
	
	public static final void entry0(String var0, Object var1)
	{
		if(entry1.entry100(var0).booleanValue())
		{
			entry1.entry1(var0, var1);
		} else
		{
			entry1.entry0(var0, var1);
		}
	}
	
	public static final int entry0(String[] var0, String var1)
	{
		for(int var2 = 0; var2 < var0.length; ++var2)
		{
			for(String element : var0)
			{
				if(var0[var2].equals(var1)) return var2;
			}
		}
		return -1;
	}
	
	public static final void entry1()
	{
		String var0 = "jcr_theme.php?action=theme&version=v5.0&request=";
		try
		{
			if(entry100())
			{
				LauncherAuthFrame.log("Загужаю online тему...");
				String[] var1 = LauncherAuthFrame.entry1[1].split("<:i:>");
				for(int var2 = 0; var2 < var1.length; ++var2)
				{
					entry0(loadRemoteImage(resolveScript(var0), var1[var2]), var2);
					if(errorLoading)
					{
						break;
					}
				}
				if(!errorLoading)
				{
					LauncherAuthFrame.log("Online тема успешо загружена");
				} else
				{
					LauncherAuthFrame.error("Не удалось загрузить элементы online темы, запускаю тему по умолчанию");
				}
			} else
			{
				errorLoading = true;
			}
		} catch(Exception var3)
		{
			errorLoading = true;
			LauncherAuthFrame.error("Не удалось загрузить online тему, запускаю тему по умолчанию");
		}
		if(errorLoading)
		{
			entry0((BufferedImage) null, -1);
			class1035.entry0 = Color.decode(getSettings().getColorScheme());
		} else
		{
			class1035.entry0 = LauncherFontManager.entry0();
		}
	}
	
	public static final String entry1(String var0)
	{
		return "http://qoobworld.ru//MineCraft/MinecraftDownload/" + var0;
	}
	
	public static final String[] entry10()
	{
		LauncherAuthFrame.log("Загружаю online настройки...");
		try
		{
			String var0 = execute(resolveScript("jcr_theme.php"), "?action=settings&request=elements&version=v5.0", false);
			if(var0 == null)
			{
				LauncherAuthFrame.error("Не удалось загрузить online настройки");
				return null;
			} else if(var0.contains("<::>")) return var0.replaceAll("<br>", "").split("<::>");
			else
			{
				LauncherAuthFrame.error("Не удалось загрузить online настройки");
				return null;
			}
		} catch(Exception var1)
		{
			LauncherAuthFrame.error("Не удалось загрузить online настройки");
			return null;
		}
	}
	
	public static final boolean entry100()
	{
		try
		{
			return LauncherAuthFrame.entry1[0].equals("true");
		} catch(Exception var1)
		{
			return false;
		}
	}
	
	public static final String entry100(String var0)
	{
		return entry1("files/" + var0);
	}
	
	public static final String[] entry1000()
	{
		String[] var0 = new String[] { "Ошибка подключения", "error" };
		try
		{
			String var1 = execute(resolveScript("jcr_status.php"), "?action=servers", false);
			if(var1 == null)
			{
				LauncherAuthFrame.error("Не удалось загрузить список серверов");
				return var0;
			} else if(!var1.contains(" :: "))
			{
				LauncherAuthFrame.error("Не удалось загрузить список серверов");
				return var0;
			} else
			{
				entry10 = var1.replaceAll("<br>", "").split("<::>");
				String[] var2 = new String[entry10.length];
				for(int var3 = 0; var3 < entry10.length; ++var3)
				{
					var2[var3] = entry10[var3].split(" :: ")[0];
				}
				return var2;
			}
		} catch(Exception var4)
		{
			LauncherAuthFrame.error("Не удалось загрузить список серверов");
			return var0;
		}
	}
	
	public static final void entry1000(String var0)
	{
		if(entry1.entry100(var0).booleanValue())
		{
			entry1.entry1000(var0);
		}
	}
	
	public static final String[] entry1001()
	{
		int var0 = LauncherAuthFrame.entry1001.entry1004.entry0();
		return entry10 != null ? entry10[var0].split(" :: ") : null;
	}
	
	public static final String entry1001(String var0)
	{
		return entry1.entry100(var0).booleanValue() ? entry1.entry0(var0) : null;
	}
	
	public static final boolean entry1002(String var0)
	{
		return entry1.entry100(var0).booleanValue() ? entry1.entry10(var0).booleanValue() : false;
	}
	
	public static final String entry1003()
	{
		return resolveMinecraftDirectory(".qoob") + "";
	}
	
	public static final int entry1003(String var0)
	{
		return entry1.entry100(var0).booleanValue() ? entry1.entry1(var0).intValue() : 0;
	}
	
	public static final void entry1004(String var0) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException
	{
		try
		{
			Object var1 = Class.forName("java.awt.Desktop").getMethod("getDesktop", new Class[0]).invoke((Object) null, new Object[0]);
			var1.getClass().getMethod("browse", new Class[] { URI.class }).invoke(var1, new Object[] { new URI(var0) });
		} catch(URISyntaxException var2)
		{
			LauncherAuthFrame.error("Не удалось открыть ссылку: " + var0);
		}
	}
	
	public static final void entry1006() throws IOException
	{
		LauncherAuthFrame var0 = LauncherAuthFrame.entry1001;
		if(var0.entry1015.isSelected())
		{
			entry0("login", class1000.entry0(var0.entry1007.getText()));
			entry0("password", class1000.entry0(new String(var0.entry1008.getPassword())));
			entry0("server", Integer.valueOf(var0.entry1004.entry0()));
		} else
		{
			entry1000("login");
			entry1000("password");
		}
		byte var1;
		if(var0.entry1015.isSelected())
		{
			var1 = 1;
		} else
		{
			var1 = 2;
		}
		entry0("remember", Integer.valueOf(var1));
		entry0("full_screen", Boolean.valueOf(var0.entry1017.isSelected()));
	}
	
	public static final void entry1007()
	{
		entry1008();
	}
	
	public static final void entry1008()
	{
		if(LauncherAuthFrame.entry1001.entry1016.isSelected())
		{
			entry1000(resolveClient() + "_hashZip");
			delete(new File(getMinecraftDirectory()));
		}
		boolean var0 = false;
		String[] var1 = LauncherAuthFrame.settings;
		String[] var2 = var1[9].split("<:m:>");
		String[] var3 = var1[13].split("<:m:>");
		String[] var4 = var1[15].split("<:n:>");
		ArrayList var5 = new ArrayList();
		String var6 = getMinecraftDirectory() + File.separator + "bin" + File.separator;
		String var7 = getMinecraftDirectory() + File.separator + "mods" + File.separator;
		String var8 = getMinecraftDirectory() + File.separator + "coremods" + File.separator;
		String var9 = var6 + "natives" + File.separator;
		int var10;
		if(!var4[0].equals("nonatives") && !new File(var9).exists() || new File(var9).listFiles().length == 0)
		{
			for(var10 = 0; var10 < var4.length; ++var10)
			{
				if(!new File(var9 + var4[var10]).exists())
				{
					var5.add("bin/natives/" + var4[var10]);
				}
			}
		}
		if(!var1[0].equals(entry1001(resolveClient() + "_hashZip")))
		{
			var5.add("extra.zip");
			var0 = true;
		}
		if(!var1[1].equals(LauncherGuard.entry10(var6 + "minecraft.jar")))
		{
			var5.add("bin/minecraft.jar");
		}
		if(!var1[2].equals(LauncherGuard.entry10(var6 + "lwjgl.jar")))
		{
			var5.add("bin/lwjgl.jar");
		}
		if(!var1[3].equals(LauncherGuard.entry10(var6 + "lwjgl_util.jar")))
		{
			var5.add("bin/lwjgl_util.jar");
		}
		if(!var1[4].equals(LauncherGuard.entry10(var6 + "jinput.jar")))
		{
			var5.add("bin/jinput.jar");
		}
		String[] var11;
		if(!var2[0].equals("nomods"))
		{
			for(var10 = 0; var10 < var2.length; ++var10)
			{
				var11 = var2[var10].split("<:h:>");
				if(!var11[1].equals(LauncherGuard.entry10(var7 + var11[0])))
				{
					var5.add("mods/" + var11[0]);
				}
			}
		}
		if(!var3[0].equals("nocoremods"))
		{
			for(var10 = 0; var10 < var3.length; ++var10)
			{
				var11 = var3[var10].split("<:h:>");
				if(!var11[1].equals(LauncherGuard.entry10(var8 + var11[0])))
				{
					var5.add("coremods/" + var11[0]);
				}
			}
		}
		if(!var5.isEmpty())
		{
			LauncherAuthFrame.log("Список загружаемых файлов: ");
			Object[] var15 = var5.toArray();
			int var14 = var15.length;
			for(int var12 = 0; var12 < var14; ++var12)
			{
				Object var13 = var15[var12];
				LauncherAuthFrame.log(" * " + var13.toString());
			}
		}
		entry0 = new class1044(var5, var0, var1);
		LauncherAuthFrame.entry1001.entry0(4);
		entry0.start();
	}
	
	public static final void entry1009() throws IOException, NoSuchAlgorithmException, InterruptedException
	{
		LauncherAuthFrame.log("Запуск процесса обновления программы...");
		String var0 = entry100("program/" + LauncherAuthFrame.settings[14]);
		LauncherAuthFrame.log("Загрузка файла: " + var0);
		BufferedInputStream var1 = new BufferedInputStream(new URL(var0).openStream());
		FileOutputStream var2 = new FileOutputStream(LauncherGuard.getJarPath());
		boolean var3 = false;
		byte[] var4 = new byte[65536];
		MessageDigest var5 = MessageDigest.getInstance("MD5");
		int var6;
		while((var6 = var1.read(var4, 0, var4.length)) != -1)
		{
			var2.write(var4, 0, var6);
			var5.update(var4, 0, var6);
		}
		var1.close();
		var2.close();
		LauncherAuthFrame.log("Файл загружен: " + var0);
		if(getOS() == 3)
		{
			LauncherAuthFrame.log("Обновление завершено успешно");
			LauncherAuthFrame.entry1001.entry1003.entry0(false);
			LauncherAuthFrame.entry1001.entry101.setEnabled(false);
			LauncherAuthFrame.entry1001.entry1010.setEnabled(false);
			LauncherAuthFrame.entry1001.entry0("Требуется перезапуск", 1, 391);
			LauncherAuthFrame.log("Требуется перезапуск программы");
		} else
		{
			class1024.entry0((String[]) null);
			System.exit(0);
		}
	}
	
	public static final String execute(String address, String params, boolean debug)
	{
		HttpURLConnection connection = null;
		InputStream input;
		String var30 = null;
		try
		{
			try
			{
				if(debug)
				{
					LauncherAuthFrame.log("Утановка соединения с: " + address + params);
				}
				URL var4 = new URL(address + params);
				connection = (HttpURLConnection) var4.openConnection();
				connection.setRequestMethod("POST");
				connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				connection.setRequestProperty("Content-Length", "0");
				connection.setRequestProperty("Content-Language", "en-US");
				connection.setUseCaches(false);
				connection.setDoInput(true);
				connection.setDoOutput(true);
				connection.connect();
				input = connection.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(input));
				Throwable exception = null;
				StringBuilder result;
				try
				{
					result = new StringBuilder();
					String var9;
					while((var9 = reader.readLine()) != null)
					{
						result.append(var9);
					}
				} catch(Throwable var26)
				{
					exception = var26;
					throw var26;
				} finally
				{
					if(reader != null)
					{
						if(exception != null)
						{
							try
							{
								reader.close();
							} catch(Throwable e)
							{
								exception.addSuppressed(e);
							}
						} else
						{
							reader.close();
						}
					}
				}
				var30 = result.toString();
				if(debug)
				{
					LauncherAuthFrame.log("Соединение установлено. Получен ответ: \'" + var30 + "\'");
				}
				String var31 = var30;
				return var31;
			} catch(Exception var28)
			{
				if(debug)
				{
					LauncherAuthFrame.error("Не удалось установить соединение с: " + address + ", возвращаю null");
				}
			}
			input = null;
		} finally
		{
			if(connection != null)
			{
				connection.disconnect();
			}
		}
		return var30;
	}
	
	public static final String getMinecraftDirectory()
	{
		return resolveMinecraftDirectory(".qoob") + File.separator + resolveClient();
	}
	
	public static final int getOS()
	{
		String os = System.getProperty("os.name").toLowerCase();
		return os.contains("win") ? 2 : os.contains("mac") ? 3 : os.contains("solaris") ? 1 : os.contains("sunos") ? 1 : os.contains("linux") ? 0 : os.contains("unix") ? 0 : 4;
	}
	
	public static final LauncherSettings getSettings()
	{
		return LauncherSettignsStorage.settings;
	}
	
	public static final BufferedImage loadLocalImage(String name)
	{
		try
		{
			BufferedImage var1 = ImageIO.read(LauncherUtils.class.getResource(getSettings().getImagesDirectory() + name));
			LauncherAuthFrame.log("Открыто локальное изображение: " + name);
			return var1;
		} catch(Exception var2)
		{
			LauncherAuthFrame.error("Ошибка при открытии изображения: " + name);
			return new BufferedImage(1, 1, 2);
		}
	}
	
	public static final BufferedImage loadRemoteImage(String path, String name)
	{
		BufferedImage result = null;
		try
		{
			result = ImageIO.read(new URL(path + name));
			LauncherAuthFrame.log(" * Загружено изображение: " + name);
			return result;
		} catch(Exception var4)
		{
			LauncherAuthFrame.error(" * Загрузка прервана на элементе: " + name);
			errorLoading = true;
			return null;
		}
	}
	
	public static final void patchMinecraft(URLClassLoader loader)
	{
		try
		{
			String version = entry1001()[3];
			String[] versions = LauncherAuthFrame.settings[10].split("<:f:>");
			LauncherAuthFrame.log("Запуск процесса патчинга: ");
			LauncherAuthFrame.log(" * Обнаружение клиента...");
			LauncherAuthFrame.log(" * Клиент: " + resolveClient() + " :: " + version);
			LauncherAuthFrame.log(" * Поиск версии в библиотеке...");
			for(String element : versions)
			{
				if(version.contains(element.split("::")[0].replace("x", "")))
				{
					LauncherAuthFrame.log(" * Патчинг клиента...");
					Field field = loader.loadClass("net.minecraft.client.Minecraft").getDeclaredField(element.split("::")[1]);
					AccessibleObject.setAccessible(new Field[] { field }, true);
					field.set((Object) null, new File(getMinecraftDirectory()));
					LauncherAuthFrame.log(" * Файл пропатчен: net.minecraft.client.Minecraft :: " + element.split("::")[1]);
					LauncherAuthFrame.log(" * Патчинг клиента успешно завершен");
					return;
				}
			}
			LauncherAuthFrame.error(" * Данная версия клиента не обнаружена!");
			LauncherAuthFrame.error(" * Не удалось произвести патчинг клиента");
		} catch(Exception var5)
		{
			LauncherAuthFrame.error(" * Ошибка: поле клиента не корректно");
		}
	}
	
	public static final String resolveClient()
	{
		String[] var0 = entry1001();
		return var0 != null ? (var0[1] + "_" + var0[2]).toLowerCase() : null;
	}
	
	public static final String resolveExtension()
	{
		String[] extensions = new String[] { ".jar", ".exe" };
		String var1 = LauncherGuard.getJarPath().toLowerCase();
		return var1.substring(var1.lastIndexOf("/")).contains(extensions[1]) ? extensions[1] : extensions[0];
	}
	
	private static File resolveMinecraftDirectory(String var0)
	{
		String var1 = System.getProperty("user.home", ".");
		File var2;
		switch(getOS())
		{
			case 0:
			case 1:
				var2 = new File(System.getProperty("user.home", "."), var0 + File.separator);
				break;
			case 2:
				String var3 = System.getenv("AppData");
				if(var3 != null)
				{
					var2 = new File(var3, var0 + File.separator);
				} else
				{
					var2 = new File(var1, var0 + File.separator);
				}
				break;
			case 3:
				var2 = new File(var1, "Library/Application Support/" + var0 + File.separator);
				break;
			default:
				var2 = new File(var1, var0 + File.separator);
		}
		if(!var2.exists() && !var2.mkdirs())
		{
			LauncherAuthFrame.error("Директория не найдена: " + var2);
		}
		return var2;
	}
	
	public static final String resolveScript(String name)
	{
		return entry1("scripts/" + name);
	}
	
	public static final void restart()
	{
		LauncherAuthFrame.log("Перезапуск программы...");
		try
		{
			class1024.entry0((String[]) null);
		} catch(Exception var1)
		{
			var1.printStackTrace();
			return;
		}
		System.exit(0);
	}
	
	public static final void sleep(double seconds)
	{
		try
		{
			Thread.sleep((long) (seconds * 1000.0D));
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	static
	{
		entry1.entry0();
	}
}

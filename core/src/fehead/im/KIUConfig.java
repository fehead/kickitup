package fehead.im;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@NoArgsConstructor
@ToString
public class KIUConfig {
	// keySet
	private static final int NORMAL = 	0;
	private static final int FUSION	=	1;

	// joySet
	private static final int DDR	=	0;
	private static final int KOINS	=	1;

	public boolean	bcDead = false;
	public boolean	auto1_1p = false;
	public boolean	auto3_1p = false;
	public boolean	auto5_1p = false;
	public boolean	auto7_1p = false;
	public boolean	auto9_1p = false;
	public boolean	auto1_2p = false;
	public boolean	auto3_2p = false;
	public boolean	auto5_2p = false;
	public boolean	auto7_2p = false;
	public boolean	auto9_2p = false;
	public int		keySet = NORMAL;
	public boolean	optJudge = false;
	public int		joySet = DDR;


	public static KIUConfig of(File configFile) {
		try(DataInputStream is = new DataInputStream(new FileInputStream(configFile))) {
			KIUConfig ret = new KIUConfig();
			ret.readData(is);
			return ret;
		} catch (Exception e) {
			log.warning(e.getMessage());
			return new KIUConfig();
		}
	}

	public void writeToFile(File configFile) {
		try(DataOutputStream out = new DataOutputStream(new FileOutputStream(configFile))) {
			writeData(out);
		} catch (Exception e) {
			log.warning(e.getMessage());
		}
	}

	public void writeData(DataOutputStream out) throws IOException {
		out.writeInt(bcDead ? 1 : 0);
		out.writeInt(auto1_1p ? 1 : 0);
		out.writeInt(auto3_1p ? 1 : 0);
		out.writeInt(auto5_1p ? 1 : 0);
		out.writeInt(auto7_1p ? 1 : 0);
		out.writeInt(auto9_1p ? 1 : 0);
		out.writeInt(auto1_2p ? 1 : 0);
		out.writeInt(auto3_2p ? 1 : 0);
		out.writeInt(auto5_2p ? 1 : 0);
		out.writeInt(auto7_2p ? 1 : 0);
		out.writeInt(auto9_2p ? 1 : 0);
		out.writeInt(keySet);
		out.writeInt(optJudge ? 1 : 0);
		out.writeInt(joySet);
	}

	public void readData(DataInputStream in) throws IOException {
		bcDead = in.readInt() == 1 ? true : false;
		auto1_1p = in.readInt() == 1 ? true : false;
		auto3_1p = in.readInt() == 1 ? true : false;
		auto5_1p = in.readInt() == 1 ? true : false;
		auto7_1p = in.readInt() == 1 ? true : false;
		auto9_1p = in.readInt() == 1 ? true : false;
		auto1_2p = in.readInt() == 1 ? true : false;
		auto3_2p = in.readInt() == 1 ? true : false;
		auto5_2p = in.readInt() == 1 ? true : false;
		auto7_2p = in.readInt() == 1 ? true : false;
		auto9_2p = in.readInt() == 1 ? true : false;
		keySet = in.readInt();
		optJudge = in.readInt() == 1 ? true : false;
		joySet = in.readInt();
	}
}

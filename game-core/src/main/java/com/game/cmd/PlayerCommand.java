package com.game.cmd;

import com.game.net.cmd.Cmd;
import com.game.net.cmd.Command;
import com.game.net.codec.IMessage;
import com.game.net.session.Session;

@Cmd(1001)
public class PlayerCommand implements Command {

	@Override
	public void execute(Session session, IMessage req) throws Exception {
		
	}
}

package edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command;

	import java.io.IOException;

	import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelImpl;
	import edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModel;

	/**
	 * The command to move a number of tiles
	 * @author andyyang
	 *
	 */
	public class MoveNumTilesCommand implements Command {
		
		private int step;
		
		/**
		 * Default constructor
		 */
		public MoveNumTilesCommand() {
			// TODO Auto-generated constructor stub
		}
		
		/**
		 * Constructor used with steps
		 * @param step number of tiles to used
		 */
		public MoveNumTilesCommand(int step) {
			// TODO Auto-generated constructor stub
			this.step = step;
		}

		/* (non-Javadoc)
		 * @see edu.jhu.cs.pl.group18.CurseOfMalphamondConnectionManager.Command.Command#execute(edu.jhu.cs.pl.group18.CurseOfMalphamondModel.CurseOfMalphamondModelInterface)
		 */
		@Override
		public void execute(CurseOfMalphamondModel model)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			try {
				if ( model instanceof CurseOfMalphamondModelImpl ) {
					model.moveCharacter(step);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
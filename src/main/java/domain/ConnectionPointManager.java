package domain;


public class ConnectionPointManager {
	private static ConnectionPointDb Cpdb = new ConnectionPointDb();
	static {
		Cpdb.add(new ConnectionPoint("cp1", 0, 1, 2, 1));
		Cpdb.add(new ConnectionPoint("cp2", 0, 1, 2, 1));
	}
	
	/*
	 * Get one specified cp by name
	 */
	public static ConnectionPoint find(String name) {
		ConnectionPoint cp = Cpdb.find(name);
		return ((cp == null)? null:cp);
	}
	
	/*
	 * Post - Add a CP
	 */
	public static void add(ConnectionPoint cp) {
		Cpdb.add(cp);
	}
	/*
	 * Delete a CP
	 */
	public static void delete(String name) {
		ConnectionPoint cp = Cpdb.find(name);
		Cpdb.remove(cp);
	}
	/*
	 * PUT - Update a VL
	 */
	public static ConnectionPoint update(ConnectionPoint cp) {
		ConnectionPoint cp_origin = Cpdb.find(cp.getName());
		if (cp_origin == null) {
			return null;
		}
		/*
		 * Delete the old cp
		 */
		delete(cp_origin.getName());
		add(cp);
		return (cp);
	}
}

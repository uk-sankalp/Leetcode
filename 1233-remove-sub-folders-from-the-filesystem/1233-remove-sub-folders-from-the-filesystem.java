class Solution {
    public List<String> removeSubfolders(String[] folder) {
	// In ASCII, '/' is before 'a': e.g., '/a', '/a/b', '/aa'
	// After sorting the folder array, we only need to consider if the current folder is a subfolder of the previous one or not.
	Arrays.sort(folder);
	
	List<String> result = new ArrayList<>();
	
	for (String dir : folder)
		if (result.isEmpty() || !dir.startsWith(result.get(result.size()-1) + "/"))
			result.add(dir);
			
	return result;
    }
}
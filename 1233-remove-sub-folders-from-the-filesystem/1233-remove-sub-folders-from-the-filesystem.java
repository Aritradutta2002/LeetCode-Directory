class Solution {
    public List<String> removeSubfolders(String[] folders) {
        Arrays.sort(folders);
        List<String> result = new ArrayList<>();
        for (String folder : folders) {
            if (result.isEmpty() || !folder.startsWith(result.get(result.size() - 1) + "/")) {
                result.add(folder);
            }
        }
        return result;
    }
}

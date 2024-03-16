package P71SimplifyPath;

class Solution {
    public String simplifyPath(String path) {
        if (path.length() == 0)
            return "/";
        int i = 0;
        List<String> files = new ArrayList<>();
        while (i < path.length()) {
            while (i < path.length() && path.charAt(i) == '/')
                i++;
            if (i == path.length())
                break;
            StringBuilder current = new StringBuilder();
            while (i < path.length() && path.charAt(i) != '/') {
                current.append(path.charAt(i));
                i++;
            }
            String currentFile = current.toString();
            if ("..".equals(currentFile)) {
                if (files.size() > 0) {
                    files.remove(files.size() - 1);
                }
            } else if (!".".equals(currentFile)) {
                files.add(currentFile);
            }
            i++;
        }
        if (files.isEmpty()) {
            return "/";
        }
        StringBuilder result = new StringBuilder();
        for (String file : files) {
            result.append("/");
            result.append(file);
        }
        return result.toString();
    }
}
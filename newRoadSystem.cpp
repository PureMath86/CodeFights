bool newRoadSystem(std::vector<std::vector<bool>> roadRegister) {
    std::vector<int> v(roadRegister.size());
    for (int i = v.size(); i--;) {
        for (int j = v.size(); j--;) {
            if (roadRegister[i][j]) {
                v[i]++;
                v[j]--;
            }
        }
    }
    return std::all_of(v.begin(), v.end(), [](int n) {
        return n == 0;
    });
}

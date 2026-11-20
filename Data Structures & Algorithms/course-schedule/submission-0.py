from collections import defaultdict

class Solution:
    def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        
        course_prerequisites_map = defaultdict(list)
        courses_taken = set()
        completed = set()

        if not prerequisites:
            return True

        for course, prerequisite in prerequisites:
            course_prerequisites_map[course].append(prerequisite)


        def dfs(current_course):
            if current_course in completed:
                return True

            for prerequisite in course_prerequisites_map[current_course]:
                if prerequisite in courses_taken:
                    return False
                courses_taken.add(prerequisite)

                if not dfs(prerequisite):
                    return False
  
                courses_taken.remove(prerequisite)
            completed.add(current_course)
            return True


        for c in range(numCourses):
            if not dfs(c):
                return False
        return True
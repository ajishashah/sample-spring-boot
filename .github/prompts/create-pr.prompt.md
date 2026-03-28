---
description: "Quick shortcut to push the current project to GitHub and open a pull request"
mode: agent
---
Use the **GitHub Push & PR** agent to push this project and create a pull request.

- Commit message: "${input:commitMessage:Describe your changes (e.g. 'Add greeting endpoint')}"
- Branch name: "${input:branchName:Feature branch name (e.g. 'feature/greeting-api')}"
- PR title: "${input:prTitle:Pull request title (leave blank to use commit message)}"
- PR description: "${input:prDescription:Short description of what this PR does (optional)}"

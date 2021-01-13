@echo off
# Create libs folder if not exists
mkdir libs 2> NUL
# Patcher
curl.exe -o "libs/Patcher-1.5.1 (1.8.9).jar" --url "https://static.sk1er.club/repo/mods/patcher/1.5.1/1.8.9/Patcher-1.5.1%20(1.8.9).jar"
# Modcore
curl.exe -o "libs/ModCore-0.1.47 (1.8.9).jar" --url "https://static.sk1er.club/repo/mods/modcore/0.1.47/1.8.9/ModCore-0.1.47%20(1.8.9).jar"
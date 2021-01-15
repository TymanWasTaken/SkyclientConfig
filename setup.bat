@echo off
@rem # Create libs folder if not exists
mkdir libs 2> NUL
@rem # Patcher
curl.exe -o "libs/Patcher-1.5.1 (1.8.9).jar" --url "https://static.sk1er.club/repo/mods/patcher/1.5.1/1.8.9/Patcher-1.5.1 (1.8.9).jar"
@rem # Modcore
curl.exe -o "libs/ModCore-0.1.47 (1.8.9).jar" --url "https://static.sk1er.club/repo/mods/modcore/0.1.47/1.8.9/ModCore-0.1.47 (1.8.9).jar"
@rem # DSM
curl.exe -o "libs/Dankers_Skyblock_Mod-1.8.5-beta7.jar" --url "https://cdn.discordapp.com/attachments/742114256555606106/794386050369323018/Dankers_Skyblock_Mod-1.8.5-beta7.jar"
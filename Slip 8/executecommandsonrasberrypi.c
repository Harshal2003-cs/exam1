// # Example Commands for Raspberry Pi
// ls
// cd /home/pi
// touch sample.txt
// rm sample.txt
// mkdir test
// rmdir test

#include <stdio.h>
#include <stdlib.h>

int main() {

    printf("=== Executing Linux Commands on Raspberry Pi ===\n");

    // 1. List files
    printf("\n--- ls command ---\n");
    system("ls");

    // 2. Make directory
    printf("\n--- mkdir command ---\n");
    system("mkdir testFolder");

    // 3. Change directory (works only for system commands, not for C program)
    printf("\n--- cd command (shows current folder) ---\n");
    system("pwd");

    // 4. Create an empty file
    printf("\n--- touch command ---\n");
    system("touch sample.txt");
    system("ls");

    // 5. Move/rename file
    printf("\n--- mv command ---\n");
    system("mv sample.txt renamed.txt");
    system("ls");

    // 6. Remove file
    printf("\n--- rm command ---\n");
    system("rm renamed.txt");
    system("ls");

    // 7. Remove directory
    printf("\n--- rmdir command ---\n");
    system("rmdir testFolder");
    system("ls");

    // 8. Show file content
    printf("\n--- cat command ---\n");
    system("echo 'Hello Raspberry Pi' > file.txt");
    system("cat file.txt");

    // 9. View file with more
    printf("\n--- more command ---\n");
    system("more file.txt");

    // 10. View file with less
    printf("\n--- less command ---\n");
    system("less file.txt");

    // 11. Compress with gzip
    printf("\n--- gzip command ---\n");
    system("gzip file.txt");
    system("ls");

    // 12. Extract Gzip file
    printf("\n--- gunzip command ---\n");
    system("gunzip file.txt.gz");
    system("ls");

    // 13. Tar archive
    printf("\n--- tar command ---\n");
    system("tar -cvf archive.tar file.txt");
    system("ls");

    // 14. Check running processes
    printf("\n--- ps command ---\n");
    system("ps");

    // 15. Ping test
    printf("\n--- ping command (3 packets) ---\n");
    system("ping -c 3 google.com");

    // 16. Show manual page (man)
    printf("\n--- man command (example) ---\n");
    system("man ls");

    // 17. Change file owner
    printf("\n--- chown command ---\n");
    system("sudo chown pi:pi file.txt");

    // 18. Change group
    printf("\n--- chgrp command ---\n");
    system("sudo chgrp pi file.txt");

    // 19. Cron status (scheduler)
    printf("\n--- cron status ---\n");
    system("systemctl status cron");

    return 0;
}

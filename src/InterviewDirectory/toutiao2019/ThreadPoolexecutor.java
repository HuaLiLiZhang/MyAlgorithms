package InterviewDirectory.toutiao2019;


import java.util.concurrent.*;

/**
 * Created by huali on 2018/8/23.
 */
public class ThreadPoolexecutor {
    public static int count = 0;
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //ThreadPoolExecutor  threadPoolExecutor = new ThreadPoolExecutor();
        //三个参数：int corePoolSize,int maximumPoolSize,long keepAliveTime,

        //ExecutorService executorService1 = Executors.newFixedThreadPool(3);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        //ExecutorService executorService1 = Executors.newSingleThreadExecutor(5);  //5是核心线程的数量，非核心线程可以随意创建
        //ExecutorService executorService1 = Executors.newScheduledThreadPool(3); //固定大小，定时执行
        for(int i = 0;i<100;i++)
        {
            executorService1.submit(new Runnable(){
                @Override
                public void run()
                {
                    for(int i =0;i<10;i++)
                    {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+" "+i+" ");
                        count++;
                    }
                    System.out.println(Thread.currentThread().getName()+" "+count+" ");
                }
            });
        }
        //executorService1.submit(new Runnable(){
        //    @Override
        //    public void run()
        //    {
        //        for(int i =0;i<10;i++)
        //        {
        //            try {
        //                Thread.sleep(1000);
        //            } catch (InterruptedException e) {
        //                e.printStackTrace();
        //            }
        //            System.out.print(i+" ");
        //            count++;
        //        }
        //        System.out.print(count+" ");
        //    }
        //});
        //executorService1.submit(new Runnable(){
        //    @Override
        //    public void run()
        //    {
        //        for(int i =0;i<10;i++)
        //        {
        //            try {
        //                Thread.sleep(1000);
        //            } catch (InterruptedException e) {
        //                e.printStackTrace();
        //            }
        //            System.out.print(i+" ");
        //            count++;
        //        }
        //        System.out.print(count+" ");
        //    }
        //});

        executorService1.shutdown();
        //shutdown()：不会立即的终止线程池，而是要等所有任务缓存队列中的任务都执行完后才终止，但再也不会接受新的任务。
        //shutdownNow()：立即终止线程池，并尝试打断正在执行的任务，并且清空任务缓存队列，返回尚未执行的任务。


        //ExecutorService executorService = Executors.newCachedThreadPool();
        ////线程安全。concurrent包下
        //Future<Integer> future = executorService.submit(new Callable<Integer>(){
        //    @Override
        //    public Integer call()
        //    {
        //        for(int i =0;i<10;i++)
        //        {
        //            System.out.print(i+" ");
        //            count++;
        //        }
        //        return count;
        //    }
        //});
        //
        //for(int i = 0 ;i<100;i++)
        //{
        //    System.out.print(future.get()+" ");
        //}
        //
        //executorService.shutdown(); //关闭










        ////线程安全的
        //Callable<Integer> call = new Callable<Integer>(){
        //    @Override
        //    public Integer call() throws InterruptedException {
        //
        //        Thread.sleep(10);
        //        Integer j = 0;
        //        for(;j<100;j++)
        //        {
        //            System.out.print(j+" ");
        //            count++;
        //        }
        //        return count;
        //    }
        //};
        //
        //FutureTask<Integer> fut = new FutureTask<>(call);
        //
        //for(int i = 0;i<100;i++)
        //{
        //    new Thread(fut).start();
        //    System.out.print(fut.get()+" ");
        //}
    }









    //public static void main(String[] args)
    //{
    //    for(int i = 0;i<100;i++)
    //    {
    //        new Thread(new Runnable() {
    //            @Override
    //            public void run() {
    //                ThreadPoolexecutor.inc();  //多个线程同时对一个变量加加，容易出错
    //            //    加volatile关键字，就不会有问题。或者加锁
    //            }
    //        }).start();
    //    }
    //}
    //
    //public static  int count = 0;
    //public static void inc(){
    //    try {
    //        Thread.sleep(1);
    //
    //    }catch (Exception e)
    //    {
    //        e.printStackTrace();
    //    }
    //    for(int i = 0;i<10;i++)
    //    {
    //        count++;
    //        System.out.print(count+" ");
    //    }
    //}
//    线程不安全
//    1 2 3 4 5 6 7 8 9 11 11 12 14 15 17 18 19 20 21 22 14 23 24 25 26 27 28 29 30 31 16 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 54 55 56 57 58 59 60 61 63 53 64 65 66 67 68 69 70 71 62 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 97 97 99 100 101 102 103 104 98 106 107 109 110 111 112 113 114 115 116 117 118 119 120 121 122 123 124 125 128 129 130 131 132 133 134 135 136 137 138 139 140 141 105 142 143 108 144 145 146 147 148 149 150 151 152 153 154 155 156 157 158 159 160 161 162 163 164 165 166 167 168 169 170 171 172 173 174 175 176 177 178 179 180 181 182 127 183 184 185 186 187 188 189 190 191 126 192 193 194 195 196 197 198 199 200 201 202 203 204 205 206 207 208 209 210 211 212 213 214 215 216 217 218 219 220 221 222 223 225 224 227 228 229 230 231 232 233 235 236 238 239 240 241 242 243 244 226 245 237 248 249 250 251 252 234 253 255 247 246 254 256 257 258 259 260 262 263 264 267 269 270 272 273 274 275 276 277 278 279 280 281 282 283 284 285 286 287 261 288 289 290 291 292 293 294 295 296 272 297 298 299 300 301 302 270 304 305 306 307 308 309 310 311 312 269 313 314 315 316 317 318 319 320 321 267 322 323 324 325 326 327 328 329 330 265 331 332 333 334 335 336 337 303 338 339 340 342 343 344 345 346 347 341 349 350 351 352 348 356 357 354 358 359 360 361 353 357 363 364 365 366 367 368 369 370 371 356 372 373 374 375 376 377 378 379 362 380 381 382 383 384 385 386 387 388 389 390 391 392 393 394 395 396 397 398 399 400 401 402 403 404 405 406 407 408 409 410 411 412 413 414 415 416 417 418 419 420 421 422 423 424 425 426 427 428 429 430 431 432 433 434 435 436 437 438 439 440 441 442 443 444 445 446 447 448 454 454 456 457 458 459 460 461 462 463 464 455 465 466 467 468 469 470 469 471 473 474 475 476 477 478 479 480 481 471 471 483 484 485 486 487 488 489 490 491 470 492 493 494 495 496 482 472 498 499 500 501 502 503 504 505 497 506 507 508 509 513 530 531 532 533 534 535 536 537 537 538 539 540 541 542 543 544 563 564 565 566 567 568 569 570 571 572 573 574 575 576 577 578 579 580 581 511 582 583 584 585 586 587 588 589 590 590 591 592 593 594 595 596 597 598 599 510 600 601 602 603 604 605 606 607 608 562 609 610 611 612 613 614 615 616 617 561 618 619 620 621 622 623 624 625 626 560 627 628 629 630 631 632 633 634 635 559 636 637 638 639 640 641 642 643 644 558 645 646 647 648 649 650 651 652 653 557 654 655 656 657 658 659 660 661 662 556 663 664 665 666 667 668 669 670 671 555 672 673 674 675 676 677 678 679 680 554 681 682 683 684 685 686 687 688 689 553 690 691 692 693 694 695 696 697 698 552 699 700 701 702 703 704 705 706 707 551 708 709 710 711 712 713 714 715 716 550 717 719 720 721 722 723 724 725 726 727 549 728 729 730 740 741 742 743 744 745 745 746 747 748 749 750 751 752 753 754 548 755 756 757 757 547 760 759 762 763 764 765 766 767 768 769 770 546 771 772 773 774 775 776 777 778 779 545 780 781 542 782 783 784 785 786 787 788 789 790 529 528 792 793 794 795 796 797 527 527 800 801 802 803 804 805 806 807 808 526 809 810 811 812 813 814 815 816 817 524 818 819 820 821 822 823 824 825 826 524 827 828 829 830 831 832 833 834 835 522 836 837 838 839 840 841 842 843 844 521 845 846 847 848 849 850 851 521 853 854 855 856 516 858 859 860 861 862 863 864 865 866 515 867 868 869 870 871 872 873 874 875 514 876 877 878 879 880 881 882 883 884 513 857 886 887 888 889 852 890 799 891 892 893 894 895 896 897 898 798 899 791 901 902 903 904 905 906 907 908 761 909 910 911 912 913 914 915 759 759 758 918 919 920 921 922 923 924 925 926 758 927 928 929 930 931 746 932 933 934 935 936 937 938 733 732 941 942 943 944 945 946 947 948 949 731 950 951 952 953 954 955 956 957 958 718 959 960 961 962 963 964 965 940 939 968 917 969 970 971 972 973 974 975 916 976 977 978 979 980 900 981 982 983 885 984 985 986 987 988 989 990 991 967 992 993 994 995 996 997 998 966
}
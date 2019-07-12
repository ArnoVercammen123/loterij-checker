import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LottoRoosterFormComponent } from './lotto-rooster-form.component';

describe('LottoRoosterFormComponent', () => {
  let component: LottoRoosterFormComponent;
  let fixture: ComponentFixture<LottoRoosterFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LottoRoosterFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LottoRoosterFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
